use testDB

db.createCollection("oms_company_address”)

db.oms_company_address.insert([
  {
    address_name: "Office A",
    send_status: 1,
    receive_status: 0,
    name: "John Zhao",
    phone: "1234567890",
    province: "SomeProvince",
    city: "SomeCity",
    region: "SomeRegion",
    detail_address: "123 Some Street"
  },
  {
    address_name: "Office B",
    send_status: 1,
    receive_status: 1,
    name: "Jane Wang",
    phone: "0987654321",
    province: "AnotherProvince",
    city: "AnotherCity",
    region: "AnotherRegion",
    detail_address: "456 Another Street"
  }
])

db.oms_company_address.findOne()
db.oms_company_address.find()

db.oms_company_address.update(
  { name: "John Zhao" },
  { $set: { phone: “88888888888" } }
)

db.oms_company_address.remove(
  { name: "Jane Wang" }
)