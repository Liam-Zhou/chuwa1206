# Create oms_company_address table
    CREATE TABLE oms_company_address (
    id BIGINT PRIMARY KEY,
    address_name VARCHAR(200) NOT NULL,
    send_status INT(1),
    receive_status INT(1),
    name VARCHAR(64),
    phone VARCHAR(64),
    province VARCHAR(64),
    city VARCHAR(64),
    region VARCHAR(64),
    detail_address VARCHAR(200)
    );

# 2. Insert some random data to oms_company_address table
    INSERT INTO oms_company_address VALUES
    (1, 'Office', 1, 0, 'John Doe', '123-456-7890', 'California', 'Los Angeles', 'Downtown', '123 Main St'),
    (2, 'Warehouse', 0, 1, 'Jane Smith', '987-654-3210', 'California', 'San Francisco', 'Bay Area', '456 Oak St'),
    (3, 'Home', 0, 1, 'Alice Johnson', '555-123-4567', 'New York', 'Manhattan', 'Midtown', '789 Elm St');

# 3. Write a SQL query to fetch all data from oms_company_address table
    SELECT * FROM oms_company_address;

# 4. Write a SQL query to fetch top 3 records from oms_company_address table
    SELECT * FROM oms_company_address LIMIT 3;


# 5. Update oms_company_address table to set all phone to 666-6666-8888
    UPDATE oms_company_address SET phone = '666-6666-8888';

# 6. Delete one entry from oms_company_address table
    DELETE FROM oms_company_address WHERE id = 2;



### MongoDB Operations:

#### # Create testDB
# db.createCollection("testDB")

#### # Create oms_company_address collection (method: createCollection())
# db.createCollection("oms_company_address")

#### # Insert few random entries to oms_company_address collection (method: insert())
# db.oms_company_address.insert({name: "Company A", address: "123 Main St", city: "City1"})
# db.oms_company_address.insert({name: "Company B", address: "456 Oak St", city: "City2"})
# db.oms_company_address.insert({name: "Company C", address: "789 Pine St", city: "City3"})

#### # Read one entry from oms_company_address collection (method: find())
# db.oms_company_address.findOne()

#### # Read all entries from oms_company_address collection (method: find())
# db.oms_company_address.find().pretty()

#### # Update one entry from oms_company_address collection (method: update() or save())
# db.oms_company_address.update({name: "Company A"}, {$set: {city: "UpdatedCity"}})

#### # Remove one entry from oms_company_address collection (method: remove())
# db.oms_company_address.remove({name: "Company B"})
