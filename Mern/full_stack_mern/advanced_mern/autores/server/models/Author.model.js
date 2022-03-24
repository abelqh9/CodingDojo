let mongoose = require("mongoose")

let AuthorSchema = new mongoose.Schema({
    name: {
        type: String,
        required: [true, "The name is required"],
        minLength: [3, "The name must have at least 3 characters"],
        trim: true
    }
})

module.exports = mongoose.model("Author", AuthorSchema);