import React, { useState, useEffect } from 'react';
import FoodItemCard from '../components/FoodItemCard';
import { fetchItems } from '../services/api';
import { useCart } from '../context/CartContext';
import './Home.css';

const Home = () => {
  const [foodItems, setFoodItems] = useState([]);
  const [loading, setLoading] = useState(true);
  const [selectedCategory, setSelectedCategory] = useState('All');
  const [categories, setCategories] = useState(['All']);

  useEffect(() => {
    loadFoodItems();
  }, []);

  const loadFoodItems = async () => {
    try {
      const data = await fetchItems();
      console.log("Fetched items:", data); // Check what data looks like
      setFoodItems(data);

      const cats = data
        .map(item => item.category)
        .filter((value, index, self) => self.indexOf(value) === index);
      setCategories(['All', ...cats]);
    } catch (err) {
      console.error('Failed to load food items:', err);
    } finally {
      setLoading(false);
    }
  };

  const filteredItems =
    selectedCategory === 'All'
      ? foodItems
      : foodItems.filter(item => item.category === selectedCategory);

  if (loading) {
    return (
      <div className="container">
        <h2>Loading...</h2>
      </div>
    );
  }

  return (
    <div className="container">
      <div className="hero">
        <h1>🌿 Fresh & Organic Feel</h1>
        <h4>Order Fresh Groceries Online</h4>
<p>Pure, healthy, and handpicked items brought straight to your door.</p>
      </div>

      <div className="category-filters">
        {categories.map(category => (
          <button
            key={category}
            className={`btn ${
              selectedCategory === category ? 'btn--primary' : 'btn--outline'
            }`}
            onClick={() => setSelectedCategory(category)}
          >
            {category}
          </button>
        ))}
      </div>

      <div className="food-grid">
        {filteredItems.length === 0 ? (
          <p>No items found for "{selectedCategory}"</p>
        ) : (
          filteredItems.map(foodItem => (
            <FoodItemCard 
              key={foodItem.Item_id} 
              item={foodItem}
            />
          ))
        )}
      </div>
    </div>
  );
};

export default Home;