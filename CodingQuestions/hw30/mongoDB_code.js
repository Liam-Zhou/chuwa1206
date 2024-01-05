
use test;


db.createCollection("oms_company_address");


db.oms_company_address.insert([
    { name: "Company A", address: "123 Lane, Some City, Some Country", zip: "123456" },
    { name: "Company B", address: "456 Road, Another City, Another Country", zip: "789101" }
]);


var oneEntry = db.oms_company_address.findOne();
printjson(oneEntry);


var allEntries = db.oms_company_address.find();
allEntries.forEach(printjson);


db.oms_company_address.update(
    { name: "Company A" }, 
    { $set: { address: "New Address, New City, New Country", zip: "654321" } }
);


db.oms_company_address.remove({ name: "Company B" });

