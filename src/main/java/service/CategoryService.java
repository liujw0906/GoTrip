package service;

import mapper.CategoryMapper;
import model.Category;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements CategoryInt {

    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Category> listTwoCategory() {
        return categoryMapper.selectTwo();
    }

    @Override
    public Category getCategory(int id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Category> listAll() {
        return categoryMapper.selectAll();
    }

    @Override
    public void delete(int id) {
//        categoryMapper.deleteByPrimaryKey(id);
        jdbcTemplate.execute(" delete from category where id = " + id);
    }

    @Override
    public Integer insert(Category category) {
        categoryMapper.insert(category);
        return categoryMapper.selectNew(category.getName());
    }

	@Override
	public Category getCategoryByName(String name) {
		return categoryMapper.getCategoryByName(name);
	}
	
	@Override
	public void update(Category category) {
		jdbcTemplate.execute(" update category set name = '"+category.getName()+"' where id = " + category.getId());
	}
}
