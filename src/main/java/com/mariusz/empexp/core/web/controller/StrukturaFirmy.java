package com.mariusz.empexp.core.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@ManagedBean(name="treeCompany")
@ViewScoped
public class StrukturaFirmy implements Serializable{

	private static final long serialVersionUID = 1L;

	private TreeNode tree;

	
	@PostConstruct
	public void init()
	{
		tree = new DefaultTreeNode("Root",null);
		
		TreeNode poziomG = new DefaultTreeNode("P.H.P.U Max",tree);
		
		TreeNode poziom2 = new DefaultTreeNode("Centrala",poziomG);
		poziom2.getChildren().add(new DefaultTreeNode("Dział Ksiegowosc"));
		poziom2.getChildren().add(new DefaultTreeNode("Dział Logistyki"));
		poziom2.getChildren().add(new DefaultTreeNode("Dział Kontroli"));
		poziom2.getChildren().add(new DefaultTreeNode("Dział Kadr"));
		poziom2.getChildren().add(new DefaultTreeNode("Dział Handlowy"));
		poziom2.getChildren().add(new DefaultTreeNode("Magazyn1"));
		poziom2.getChildren().add(new DefaultTreeNode("Magazyn2"));
		
			
		
		TreeNode poziom3 = new DefaultTreeNode("Oddział Warszawa",poziomG);
		poziom3.getChildren().add(new DefaultTreeNode("Magazyn 3"));
		
		TreeNode poziom4 = new DefaultTreeNode("Oddział Poznan" ,poziomG);
		poziom4.getChildren().add(new DefaultTreeNode("Magazyn 4"));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public TreeNode getTree() {
		return tree;
	}

	public void setTree(TreeNode tree) {
		this.tree = tree;
	}
	

	
}
