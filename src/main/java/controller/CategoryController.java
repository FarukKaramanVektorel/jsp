package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.Article;
import dao.Category;
import utils.DBUtil;

public class CategoryController {
	private static Connection cnn;
	
	
	public static Category getById(int id) {
		Category cat=new Category();
		try {
			cnn=DBUtil.getConnection();
			String sql="select * from categories where category_id=?";
			PreparedStatement pst=cnn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			
			if(rs.next()) {
				cat.setId(rs.getInt("category_id"));
				cat.setName(rs.getString("name"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cat;
	}
	
	
	public static List<Category> getAllCategory(){
		List<Category> categories=new ArrayList();
		try {
			cnn=DBUtil.getConnection();
			PreparedStatement pst=cnn.prepareStatement("select * from categories");
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				int categoryId=rs.getInt("category_id");
				String name= rs.getString("name");
				Category cat=new Category(categoryId, name);
				categories.add(cat);				
			}
			cnn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return categories;
	}
	
	public static List<Article> getArticleByCategoryId(int categoryId){
		List<Article> articles=new ArrayList();
		try {
			cnn=DBUtil.getConnection();
			PreparedStatement pst=cnn.prepareStatement("select * from articles where category_id=?");
			pst.setInt(1, categoryId);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				int id=rs.getInt("article_id");
				String title=rs.getString("title");
				String content=rs.getString("content");
				int category_id=rs.getInt("category_id");
				Article article=new Article(id, title, content, category_id);
				
				articles.add(article);
			}
			cnn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return articles;
	}
	
	public static void addCategory(String name) {
		try {
			cnn=DBUtil.getConnection();
			PreparedStatement pst=cnn.prepareStatement("insert into categories(name) values(?)");
			pst.setString(1, name);
			pst.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
