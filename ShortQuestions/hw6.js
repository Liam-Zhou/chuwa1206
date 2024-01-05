db.getCollection("oms_company_address").find({})

// Assuming db is your MongoDB database connection
var omsCompanyAddressCollection = db.oms_company_address;

// Example data for insertion
var addressData = [
    {
        id: 1,
        address_name: "Office",
        send_status: 1,
        receive_status: 1,
        name: "John Doe",
        phone: "123-456-7890",
        province: "California",
        city: "Los Angeles",
        region: "Downtown",
        detail_address: "123 Main St"
    },
    {
        id: 2,
        address_name: "Home",
        send_status: 0,
        receive_status: 1,
        name: "Jane Smith",
        phone: "987-654-3210",
        province: "New York",
        city: "New York City",
        region: "Midtown",
        detail_address: "456 Oak St"
    },
    // Add more entries as needed
];

// Insert the data into the collection
omsCompanyAddressCollection.insert(addressData);

db.oms_company_address.findOne();

db.oms_company_address.find();

db.oms_company_address.updateOne({ address_name: "Office" }, {
    $set: {
        send_status: 0,  // New value for send_status
        receive_status: 1  // New value for receive_status
    }
});

db.oms_company_address.deleteOne({ address_name: "Office" });