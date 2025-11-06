import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { useCart } from '../context/CartContext';
import { createOrder } from '../services/api'; // Your api call function
import './Checkout.css';

const API_BASE_URL = 'http://localhost:8080';

const Checkout = () => {
  const { cartItems, getTotalAmount, clearCart } = useCart();
  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    customerName: '',
    customerEmail: '',
    phoneNumber: '',
    deliveryAddress: '',
  });

  const [loading, setLoading] = useState(false);
  const [error, setError] = useState('');

  const handleChange = (e) => {
    setFormData(prev => ({
      ...prev,
      [e.target.name]: e.target.value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);
    setError('');

    try {
      // Prepare the order payload matching backend DTO naming
      const orderData = {
        customer_name: formData.customerName,
        customer_address: formData.deliveryAddress,
        customer_phone_number: formData.phoneNumber,
        cart_item: cartItems.map(item => ({
          cartItemId: item.Item_id || item.id,
          name: item.name,
          discription: item.description, // spelling 'discription' to match backend DTO if needed
          price: item.price,
          quantity: item.quantity,
          weightVariant: item.weightVariant,
          image_url: item.image_url || item.imageUrl,
        })),
      };

      console.log('Sending order data:', orderData);
      await createOrder(orderData);
      clearCart();
      alert('Order placed successfully!');
      navigate('/');
    } catch (err) {
      setError('Failed to place order. Please try again.');
      console.error('Order submission error:', err);
      console.error('Error details:', err.response?.data);
    } finally {
      setLoading(false);
    }
  };

  const getImageUrl = (item) => {
    if (!item.image_url && !item.imageUrl) {
      return 'https://via.placeholder.com/80x80?text=No+Image';
    }
    const imagePath = item.image_url || item.imageUrl;
    return imagePath.startsWith('/')
      ? `${API_BASE_URL}${imagePath}`
      : imagePath;
  };

  if (cartItems.length === 0) {
    navigate('/');
    return null;
  }

  return (
    <div className="container">
      <h1>Checkout</h1>
      <div className="checkout-container">
        <div className="checkout-form">
          <div className="card">
            <div className="card__body">
              <h2>Delivery Information</h2>
              <form onSubmit={handleSubmit}>
                <div className="form-group">
                  <label className="form-label">Full Name *</label>
                  <input
                    type="text"
                    name="customerName"
                    className="form-control"
                    value={formData.customerName}
                    onChange={handleChange}
                    required
                  />
                </div>
                <div className="form-group">
                  <label className="form-label">Email *</label>
                  <input
                    type="email"
                    name="customerEmail"
                    className="form-control"
                    value={formData.customerEmail}
                    onChange={handleChange}
                    required
                  />
                </div>
                <div className="form-group">
                  <label className="form-label">Phone Number *</label>
                  <input
                    type="tel"
                    name="phoneNumber"
                    className="form-control"
                    value={formData.phoneNumber}
                    onChange={handleChange}
                    required
                    pattern="[0-9]{10}"
                    placeholder="10-digit phone number"
                  />
                </div>
                <div className="form-group">
                  <label className="form-label">Delivery Address *</label>
                  <textarea
                    name="deliveryAddress"
                    className="form-control"
                    rows="3"
                    value={formData.deliveryAddress}
                    onChange={handleChange}
                    required
                  ></textarea>
                </div>
                {error && <p className="error-message">{error}</p>}
                <button
                  type="submit"
                  className="btn btn--primary btn--full-width"
                  disabled={loading}
                >
                  {loading ? 'Placing Order...' : 'Place Order'}
                </button>
              </form>
            </div>
          </div>
        </div>

        <div className="order-summary-checkout">
          <div className="card">
            <div className="card__body">
              <h2>Order Summary</h2>
              {cartItems.map(item => (
                <div key={item.cartKey || `${item.Item_id}-${item.weightVariant}`} className="summary-item">
                  <div style={{ display: 'flex', alignItems: 'center', gap: '12px' }}>
                    <img
                      src={getImageUrl(item)}
                      alt={item.name}
                      style={{
                        width: '50px',
                        height: '50px',
                        borderRadius: '6px',
                        objectFit: 'cover',
                      }}
                      onError={e => { e.target.onerror = null; e.target.src = 'https://via.placeholder.com/50x50?text=No+Image'; }}
                    />
                    <div>
                      <p style={{ margin: 0, fontWeight: 600 }}>{item.name}</p>
                      <p className="item-quantity">
                        Qty: {item.quantity} | Weight: {item.weightVariant}
                      </p>
                    </div>
                  </div>
                  <p style={{ fontWeight: 600, color: '#ff6b00' }}>
                    ₹{(item.price * item.quantity).toFixed(2)}
                  </p>
                </div>
              ))}
              <hr />
              <div className="summary-row">
                <span>Subtotal:</span>
                <span>₹{getTotalAmount().toFixed(2)}</span>
              </div>
              <div className="summary-row">
                <span>Delivery Fee:</span>
                <span>₹40.00</span>
              </div>
              <div className="summary-row summary-total">
                <span>Total:</span>
                <span>₹{(getTotalAmount() + 40).toFixed(2)}</span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Checkout;
