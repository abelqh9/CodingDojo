let mongoose = require("mongoose")

let ProductSchema = new mongoose.Schema({
    title: {
        type: String
    },
    price: {
        type: Number
    },
    description: {
        type: String
    }
})

module.exports = mongoose.model("Product", ProductSchema);