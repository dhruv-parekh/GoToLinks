package com.dareProjects.gotoLinks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dareProjects.gotoLinks.beans.Categories;
import com.dareProjects.gotoLinks.beans.Links;
import com.dareProjects.gotoLinks.beans.User;
import com.dareProjects.gotoLinks.dao.CategoriesRepository;
import com.dareProjects.gotoLinks.dao.LinksRepository;
import com.dareProjects.gotoLinks.dao.UserRepository;

@Service
@Transactional
public class LinkService {
	
	private UserRepository userRepository;
	private LinksRepository linksRepository;
	private CategoriesRepository categoriesRepository;
	
	public LinkService(UserRepository userRepository, LinksRepository linksRepository,
			CategoriesRepository categoriesRepository) {
		super();
		this.userRepository = userRepository;
		this.linksRepository = linksRepository;
		this.categoriesRepository = categoriesRepository;
	}

	public List<Links> findLinksByEmail(String email) {

		User user =  userRepository.findUserByEmail(email);
		List<Links> listOfLinks = linksRepository.findAllByUserId(user.getUserId());
		
		return listOfLinks;
	}

	public void deleteLink(int linkId) {
		// TODO Auto-generated method stub
		linksRepository.deleteById(linkId);
		
	}

	public Links getLinkByEmailAndId( int linkId) {
		Links link = linksRepository.findById(linkId).get();
		return link;  
	}

	public List<Categories> getAllCategories() {
		
		List<Categories> categoriesList = categoriesRepository.findAll();
		return categoriesList;
	}

	public void updateLinks(Links links) {
		
		linksRepository.save(links);
		
	}

	public User findUserByEmail(String email) {
		User user = userRepository.findUserByEmail(email);
		return user;
	}

	public void addCategory(Categories category) {
		categoriesRepository.save(category);
		
	}


	public List<Categories> findAllCategories() {
		
		List<Categories> listOfCategories = categoriesRepository.findAll();
		
		return listOfCategories;
	}

	public void deleteCategoryById(int categoryId) {
		categoriesRepository.deleteById(categoryId);
		
	}

	public Categories findCategoryById(int categoryId) {
		Categories category = categoriesRepository.findById(categoryId).get();
		return category;
	}

	public void deleteLinksByCategoryId(int categoryId) {
		linksRepository.deleteLinksByCategoryId(categoryId);
		
	}

	public List<Links> findLinksByEmailAndCategory(String email, int categoryId) {
		User user = userRepository.findUserByEmail(email);
		List<Links> listOfLinks = linksRepository.findLinksByUserIdAndCategoryId(user.getUserId(),categoryId);
		return listOfLinks;
	}

}
