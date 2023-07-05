package com.dareProjects.gotoLinks.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dareProjects.gotoLinks.beans.Categories;
import com.dareProjects.gotoLinks.beans.Links;
import com.dareProjects.gotoLinks.beans.User;
import com.dareProjects.gotoLinks.service.LinkService;

@Controller
@SessionAttributes("email")
public class LinkController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	private LinkService linkService;

	public LinkController(LinkService linkService) {
		super();
		this.linkService = linkService;
	}

	@RequestMapping(value = { "/welcome", "/" })
	public String gotoWelcome(ModelMap model) {
		model.put("email", getAuthenticatedUsername(model));
		return "welcome";
	}

	@RequestMapping("/listAllLinks")
	public String gotoListAllLinks(ModelMap model) {
		String email = (String) model.get("email");
		model.put("category", new Categories());
		List<Categories> listOfCategories = linkService.findAllCategories();
		List<Links> listOfLinks = linkService.findLinksByEmail(email);
		model.put("category", new Categories());
		model.put("listOfCategories", listOfCategories);
		model.put("listOfLinks", listOfLinks);
		return "listAllLinks";
	}

	@RequestMapping("/deleteLinks")
	public String deleteLink(ModelMap model, @RequestParam int linkId) {
		linkService.deleteLink(linkId);
		return "redirect:listAllLinks";
	}

	@RequestMapping(value = "addLinks", method = RequestMethod.GET)
	public String gotoAddLink(ModelMap model) {
		logger.info("in get Add or Update links");
		String email = (String) model.get("email");
		User user = linkService.findUserByEmail(email);
		Links links = new Links("Please enter link Name.", "Enter Url", 1, user.getUserId());
		List<Categories> categoriesList = linkService.getAllCategories();
		model.put("links", links);
		model.put("categoriesList", categoriesList);
		logger.info("in get Add or Update links");
		return "addOrUpdateLinks";
	}

	@RequestMapping(value = "addLinks", method = RequestMethod.POST)
	public String addLink(ModelMap model, Links links) {
		linkService.updateLinks(links);
		return "redirect:listAllLinks";
	}

	@RequestMapping(value = "/updateLinks", method = RequestMethod.GET)
	public String gotoUpdateLink(ModelMap model, @RequestParam int linkId) {
		logger.info("in get Add or Update links");
		Links links = linkService.getLinkByEmailAndId(linkId);
		List<Categories> categoriesList = linkService.getAllCategories();

		model.put("links", links);
		model.put("categoriesList", categoriesList);
		logger.info("in get Add or Update links");
		return "addOrUpdateLinks";
	}

	@RequestMapping(value = "/updateLinks", method = RequestMethod.POST)
	public String UpdateLink(ModelMap model, Links links) {

		linkService.updateLinks(links);
		return "redirect:listAllLinks";
	}
	
	@RequestMapping(value =  "/filterLinksByCategory", method = RequestMethod.POST)
	public String filterLinksByCategory(ModelMap model, Categories category) {
		List<Categories> listOfCategories = linkService.findAllCategories();
		String email = (String) model.get("email");
		List<Links> listOfLinks = linkService.findLinksByEmailAndCategory(email, category.getCategoryId());
		model.put("category", new Categories());
		model.put("listOfCategories", listOfCategories);
		model.put("listOfLinks", listOfLinks);
		return "listAllLinks";
	}

	@RequestMapping("/listAllCategories")
	public String gotoListAllCategories(ModelMap model) {
		List<Categories> listOfCategories = linkService.findAllCategories();
		model.put("listOfCategories", listOfCategories);
		return "listAllCategories";
	}

	@RequestMapping(value = "addCategory", method = RequestMethod.GET)
	public String gotoAddCategory(ModelMap model) {
		Categories category = new Categories("Input Category");
		model.put("category", category);
		logger.info("in get Add or Update links");
		return "addOrUpdateCategory";
	}

	@RequestMapping(value = "addCategory", method = RequestMethod.POST)
	public String AddCategory(ModelMap model, Categories category) {
		linkService.addCategory(category);
		return "redirect:listAllLinks";
	}

	@RequestMapping(value = "updateCategory", method = RequestMethod.GET)
	public String gotoUpdateCategory(ModelMap model, @RequestParam int categoryId) {
		Categories category = linkService.findCategoryById(categoryId);
		model.put("category", category);
		logger.info("in get Add or Update links");
		return "addOrUpdateCategory";
	}

	@RequestMapping(value = "updateCategory", method = RequestMethod.POST)
	public String UpdateCategory(ModelMap model, Categories category) {
		linkService.addCategory(category);
		return "redirect:listAllCategories";
	}

	@RequestMapping(value = "deleteCategory", method = RequestMethod.GET)
	public String deleteCategory(ModelMap model, @RequestParam int categoryId) {

		linkService.deleteLinksByCategoryId(categoryId);
		linkService.deleteCategoryById(categoryId);
		return "redirect:listAllCategories";
	}

	// Spring security method to get username instead of getting it from session.
	private Object getAuthenticatedUsername(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

}
