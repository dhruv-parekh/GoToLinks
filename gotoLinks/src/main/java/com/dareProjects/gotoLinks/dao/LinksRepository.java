package com.dareProjects.gotoLinks.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dareProjects.gotoLinks.beans.Links;

public interface LinksRepository extends JpaRepository<Links, Integer> {

	List<Links> findAllByUserId(int userId);

	Links findByLinkId(int linkId);

	void deleteLinksByCategoryId(int categoryId);

	List<Links> findLinksByUserIdAndCategoryId(int userId, int categoryId);


}
