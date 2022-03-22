let mongoose = require("mongoose");

let jokeSchema = new mongoose.Schema({
    setup: {
		type: String,
		required: [true, "SetUp is required"],
		minLength: [10, "SetUp must be at least 10 characters long"]
	},
	punchline: {
		type: String,
		required: [true, "Punchline is required"],
		minLength: [3, "Punchline must be at least 3 characters long"]
	}
}, {timestamps: true});

module.exports = mongoose.model("Joke", jokeSchema);