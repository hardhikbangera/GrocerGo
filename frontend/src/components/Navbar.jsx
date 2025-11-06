import React from 'react';
import { Link } from 'react-router-dom';
import { useCart } from '../context/CartContext';
import './Navbar.css';

const Navbar = () => {
    const { getTotalItems, getUniqueItems } = useCart();

    return (
        <nav className="navbar">
            <div className="navbar-container">
                <Link to="/" className="navbar-logo">
                    <img 
                        src="/logo.png"  
                        alt="Logo"
                        className="logo-image"
                    />
                </Link>
                <ul className="navbar-menu">
                    <li>
                        <Link to="/" className="navbar-link">Home</Link>
                    </li>
                    <li>
                        <Link to="/cart" className="navbar-link">
                            🛒 Cart ({getUniqueItems()} Items)
                        </Link>
                    </li>
                </ul>
            </div>
        </nav>
    );
};

export default Navbar;
