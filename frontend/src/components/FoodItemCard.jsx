import React, { useState } from "react";
import { useCart } from "../context/CartContext";
import "./FoodItemCard.css";

const weightOptions = [
  { label: "250g", multiplier: 0.25 },
  { label: "500g", multiplier: 0.5 },
  { label: "1kg", multiplier: 1 },
  { label: "2kg", multiplier: 2 },
  { label: "5kg", multiplier: 5 },
];

const API_BASE_URL = "http://localhost:8080";

const FoodItemCard = ({ item }) => {
  const { addToCart } = useCart();
  const [selectedWeight, setSelectedWeight] = useState(weightOptions[2]); // Default: 1kg

  const itemId = item.Item_id || item.id;

  const basePrice =
    item.pricePer1kg ||
    item.pricePer250g ||
    item.pricePer500g ||
    item.pricePer2kg ||
    item.pricePer5kg ||
    item.price ||
    0;

  const calculatedPrice = (basePrice * selectedWeight.multiplier).toFixed(2);

  const handleAddToCart = () => {
    const cartItem = {
      id: itemId,
      Item_id: itemId,
      name: item.name,
      description: item.description,
      image_url: item.image_url,
      category: item.category,
      quantity: 1,
      price: Number(calculatedPrice),
      weightVariant: selectedWeight.label,
    };
    addToCart(cartItem);
  };

  const getImageUrl = () => {
    if (!item.image_url && !item.imageUrl) {
      return "https://via.placeholder.com/200x140?text=No+Image";
    }
    const imagePath = item.image_url || item.imageUrl;
    return imagePath.startsWith("/")
      ? `${API_BASE_URL}${imagePath}`
      : imagePath;
  };

  return (
    <div className="food-card" style={{ position: "relative" }}>
      {/* Small badge on the top left */}
      <span className="food-card-category">{item.category}</span>
      <img
        src={getImageUrl()}
        alt={item.name}
        className="food-card-image"
        onError={(e) => {
          e.target.onerror = null;
          e.target.src = "https://via.placeholder.com/200x140?text=Image+Error";
        }}
      />
      <div className="food-card-content">
        <h3 className="food-card-title">{item.name}</h3>
        <p className="food-card-description">{item.description}</p>
        <div style={{ margin: "10px 0" }}>
          <select
            value={selectedWeight.label}
            onChange={(e) => {
              const option = weightOptions.find(
                (opt) => opt.label === e.target.value
              );
              setSelectedWeight(option);
            }}
            className="food-card-select"
            style={{ width: "100%", padding: "4px", borderRadius: "4px" }}
          >
            {weightOptions.map((option) => (
              <option key={option.label} value={option.label}>
                {option.label}
              </option>
            ))}
          </select>
        </div>
        {/* Price section */}
        <div className="food-card-price-standalone">₹{calculatedPrice}</div>
        {/* Add to Cart button */}
        <button
          className="btn btn--primary food-card-add-btn"
          onClick={handleAddToCart}
        >
          Add To Cart
        </button>
      </div>
    </div>
  );
};

export default FoodItemCard;
