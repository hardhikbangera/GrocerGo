import React from 'react';
import { useNavigate } from 'react-router-dom';
import { useCart } from '../context/CartContext';
import './Cart.css';

const API_BASE_URL = 'http://localhost:8080';

const Cart = () => {
  const { cartItems, incrementQuantity, decrementQuantity, removeFromCart, getTotalAmount } = useCart();
  const navigate = useNavigate();

  const getImageUrl = (item) => {
    if (!item.image_url && !item.imageUrl) {
      return 'https://via.placeholder.com/100x100?text=No+Image';
    }
    const imagePath = item.image_url || item.imageUrl;
    return imagePath.startsWith('/') 
      ? `${API_BASE_URL}${imagePath}` 
      : imagePath;
  };

  if (cartItems.length === 0) {
    return (
      <div className="container">
        <div className="empty-cart">
          <h2>Your cart is empty</h2>
          <p style={{ color: '#666', marginBottom: '20px' }}>
            Add some delicious items to get started!
          </p>
          <button className="btn btn--primary" onClick={() => navigate('/')}>
            Browse Food Items
          </button>
        </div>
      </div>
    );
  }

  return (
    <div className="container">
      <h1>Shopping Cart</h1>
      <div className="cart-container">
        <div className="cart-items">
          {cartItems.map(item => (
            <div key={item.cartKey} className="cart-item">
              <img
                src={getImageUrl(item)}
                alt={item.name}
                className="cart-item-image"
                onError={(e) => {
                  e.target.onerror = null;
                  e.target.src = 'https://via.placeholder.com/100x100?text=No+Image';
                }}
              />
              <div className="cart-item-details">
                <h3>{item.name}</h3>
                <p className="cart-item-price">₹{item.price.toFixed(2)}</p>
                <p className="cart-item-weight">Weight: {item.weightVariant}</p>
              </div>
              <div className="cart-item-actions">
                <div className="quantity-controls">
                  <button
                    className="btn btn--sm"
                    onClick={() => decrementQuantity(item.cartKey)}
                    aria-label="Decrease quantity"
                  >
                    -
                  </button>
                  <span className="quantity-display">{item.quantity}</span>
                  <button
                    className="btn btn--sm"
                    onClick={() => incrementQuantity(item.cartKey)}
                    aria-label="Increase quantity"
                  >
                    +
                  </button>
                </div>
                <p className="cart-item-total">
                  ₹{(item.price * item.quantity).toFixed(2)}
                </p>
                <button
                  className="btn btn--outline btn--sm"
                  onClick={() => removeFromCart(item.cartKey)}
                  style={{ marginTop: '8px' }}
                >
                  Remove
                </button>
              </div>
            </div>
          ))}
        </div>
        
        <div className="cart-summary">
          <div className="card">
            <div className="card__body">
              <h2>Order Summary</h2>
              <div className="summary-row">
                <span>Items ({cartItems.reduce((sum, item) => sum + item.quantity, 0)}):</span>
                <span>₹{getTotalAmount().toFixed(2)}</span>
              </div>
              <div className="summary-row">
                <span>Delivery Fee:</span>
                <span>₹40.00</span>
              </div>
              <hr style={{ margin: '12px 0', border: 'none', borderTop: '1px solid #eee' }} />
              <div className="summary-row summary-total">
                <span>Total:</span>
                <span>₹{(getTotalAmount() + 40).toFixed(2)}</span>
              </div>
              <button
                className="btn btn--primary btn--full-width"
                onClick={() => navigate('/checkout')}
                style={{ marginTop: '16px' }}
              >
                Proceed To Checkout
              </button>
              <button
                className="btn btn--outline btn--full-width"
                onClick={() => navigate('/')}
                style={{ marginTop: '10px' }}
              >
                Continue Shopping
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Cart;
