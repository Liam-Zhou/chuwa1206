use test

db.oms_company_address.drop()

db.createCollection("oms_company_address")

db.oms_company_address.insertMany([
    { company_id: 1, company_name: 'Company A', address: '123 Main St', phone: '555-1234-5678' },
    { company_id: 2, company_name: 'Company B', address: '456 Oak St', phone: '555-9876-5432' },
    { company_id: 3, company_name: 'Company C', address: '789 Pine St', phone: '555-1111-2222' }
    // Add more entries as needed
])

db.oms_company_address.findOne({ company_id: 1 })

db.oms_company_address.find()

db.oms_company_address.updateOne(
    { company_id: 1 },
    { $set: { phone: '666-6666-8888' } }
)

db.oms_company_address.deleteOne({ company_id: 1 })