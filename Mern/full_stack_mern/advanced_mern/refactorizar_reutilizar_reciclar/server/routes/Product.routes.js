let ProductController = require("../controllers/Product.controller");

module.exports = function(app) {
    app.get("/api/products", ProductController.getAllProducts)
    app.get("/api/products/:id", ProductController.getOneProduct)
    
    app.put("/api/products/:id", ProductController.updateProduct)
    
    app.delete("/api/products/:id", ProductController.deleteProduct)
    
    app.post("/api/products/new", ProductController.createProduct)
}