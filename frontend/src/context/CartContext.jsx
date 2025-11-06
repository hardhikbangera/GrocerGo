import React, { createContext, useState, useContext } from 'react';

const CartContext = createContext();

export const useCart = () => {
    const context = useContext(CartContext);
    if (!context) {
        throw new Error('useCart must be used within CartProvider');
    }
    return context;
};

export const CartProvider = ({ children }) => {
    const [cartItems, setCartItems] = useState([]);

    // Count of *unique* cart lines
    const getUniqueItems = () => cartItems.length;

    // Total quantity of all items
    const getTotalItems = () => cartItems.reduce((total, item) => total + item.quantity, 0);

    const addToCart = (foodItem) => {
        const itemId = foodItem.id || foodItem.Item_id;
        const weightVariant = foodItem.weightVariant || '';
        // Compose a unique key per item+variant
        const cartKey = `${itemId}-${weightVariant}`;

        setCartItems(prevItems => {
            const existingItem = prevItems.find(
                item => (item.Item_id === itemId || item.id === itemId) && item.weightVariant === weightVariant
            );

            if (existingItem) {
                // Exists: update quantity
                return prevItems.map(item =>
                    (item.Item_id === itemId || item.id === itemId) && item.weightVariant === weightVariant
                        ? { ...item, quantity: item.quantity + 1 }
                        : item
                );
            }
            // Add as new unique cart line
            return [
                ...prevItems,
                {
                    ...foodItem,
                    Item_id: itemId,
                    cartKey: cartKey,
                    quantity: 1
                }
            ];
        });
    };

    const removeFromCart = (cartKey) => {
        setCartItems(prevItems => prevItems.filter(item => item.cartKey !== cartKey));
    };

    const updateQuantity = (cartKey, quantity) => {
        if (quantity <= 0) {
            removeFromCart(cartKey);
            return;
        }
        setCartItems(prevItems =>
            prevItems.map(item =>
                item.cartKey === cartKey
                    ? { ...item, quantity }
                    : item
            )
        );
    };

    const incrementQuantity = (cartKey) => {
        setCartItems(prevItems =>
            prevItems.map(item =>
                item.cartKey === cartKey
                    ? { ...item, quantity: item.quantity + 1 }
                    : item
            )
        );
    };

    const decrementQuantity = (cartKey) => {
        setCartItems(prevItems =>
            prevItems.map(item =>
                item.cartKey === cartKey && item.quantity > 1
                    ? { ...item, quantity: item.quantity - 1 }
                    : item
            ).filter(item => item.quantity > 0)
        );
    };

    const clearCart = () => setCartItems([]);

    const getTotalAmount = () =>
        cartItems.reduce((total, item) => total + (item.price * item.quantity), 0);

    return (
        <CartContext.Provider value={{
            cartItems,
            addToCart,
            removeFromCart,
            updateQuantity,
            incrementQuantity,
            decrementQuantity,
            clearCart,
            getTotalAmount,
            getTotalItems,
            getUniqueItems
        }}>
            {children}
        </CartContext.Provider>
    );
};
