// server.js
const express = require('express');
const mongoose = require('mongoose');
const cors = require('cors');

const app = express();
app.use(cors());
app.use(express.json());

// 1. Database Connection (Replace with your MongoDB URI)
// mongoose.connect('mongodb://localhost:27017/theekha_mircha', { useNewUrlParser: true, useUnifiedTopology: true });

// 2. Database Models
const menuItemSchema = new mongoose.Schema({
    name: String,
    description: String,
    price: Number,
    category: String,
    imageUrl: String,
    rating: Number
});
const MenuItem = mongoose.model('MenuItem', menuItemSchema);

const orderSchema = new mongoose.Schema({
    items: Array,
    total: Number,
    type: String, // 'Delivery', 'Pick up', 'Eat In'
    status: { type: String, default: 'Pending' },
    createdAt: { type: Date, default: Date.now }
});
const Order = mongoose.model('Order', orderSchema);

// 3. API Routes

// Get all menu items
app.get('/api/menu', async (req, res) => {
    try {
        // Fallback mock data if DB isn't connected
        const mockMenu = [
            { id: 1, name: "Chicken Hot Garlic", price: 279, category: "Chicken", rating: 5, imageUrl: "https://images.unsplash.com/photo-1604908176997-125f25cc6f3d?w=500&q=80" },
            { id: 2, name: "Mushroom Chilly", price: 220, category: "Veg", rating: 4.5, imageUrl: "https://images.unsplash.com/photo-1626074353765-517a681e40be?w=500&q=80" },
            { id: 3, name: "Chicken Mixed Chowmein", price: 190, category: "Noodles", rating: 5, imageUrl: "https://images.unsplash.com/photo-1617093727343-374698b1b08d?w=500&q=80" }
        ];
        // const menu = await MenuItem.find(); // Use this when DB is ready
        res.json(mockMenu);
    } catch (err) {
        res.status(500).json({ error: err.message });
    }
});

// Submit a new order
app.post('/api/orders', async (req, res) => {
    try {
        const { items, total, type } = req.body;
        // const newOrder = new Order({ items, total, type });
        // await newOrder.save();
        res.status(201).json({ message: 'Order placed successfully!', orderId: Math.floor(Math.random() * 10000) });
    } catch (err) {
        res.status(500).json({ error: err.message });
    }
});

// 4. Start Server
const PORT = process.env.PORT || 5000;
app.listen(PORT, () => console.log(`Backend running flawlessly on port ${PORT}`));
