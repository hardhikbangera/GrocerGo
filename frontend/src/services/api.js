import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api';

// Item_detailsController endpoints
export const fetchItems = async () => {
    const response = await axios.get(`${API_BASE_URL}`);
    return response.data;
};

export const getItemById = async (id) => {
    const response = await axios.get(`${API_BASE_URL}/item-details/${id}`);
    return response.data;
};

export const getItemsByCategory = async (category) => {
    const response = await axios.get(`${API_BASE_URL}/category/${category}`);
    return response.data;
};

// Customer_detailsController endpoints
export const getAllOrders = async () => {
    const response = await axios.get(`${API_BASE_URL}/orders`);
    return response.data;
};

export const createOrder = async (orderData) => {
    const response = await axios.post(`${API_BASE_URL}/orders`, orderData);
    return response.data;
};

// Order_itemsController endpoints
export const getAllOrderItems = async () => {
    const response = await axios.get(`${API_BASE_URL}/allItem`);
    return response.data;
};

export const getOrderItemById = async (id) => {
    const response = await axios.get(`${API_BASE_URL}/order-items/${id}`);
    return response.data;
};
