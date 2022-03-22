let { faker } = require("@faker-js/faker");

class User {
    constructor() {
        // No entendí la propiedad "_carné de identidad" asi que generé un numero de id
        this.id = faker.finance.routingNumber();
        this.first_name = faker.name.firstName();
        this.last_name = faker.name.lastName();
        this.phone_number = faker.phone.phoneNumber();
        this.email = faker.internet.email(this.first_name, this.last_name);
        this.password = faker.internet.password();
    }
}

class Company {
    constructor() {
        // No entendí la propiedad "_carné de identidad" asi que generé un numero de id
        this.id = faker.finance.routingNumber();
        this.name = faker.company.companyName();
        this.direction = faker.address.streetName()+", "+faker.address.cityName() +", "+faker.address.state()+", "+faker.address.zipCode()+", "+faker.address.country();
    }
}

const express = require('express')
const app = express()
const port = 3000

app.get('/api/users/new', (req, res) => {
    res.json(new User());
})

app.get('/api/companies/new', (req, res) => {
    res.json(new Company());
})

app.get('/api/user/company', (req, res) => {
    res.json({
        user: new User(),
        company: new Company()
    });
})

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})