# Start mongodb using docker
```
docker run -it -v mongodata:/data/db -p 27017:27017 --name mongodb --rm -d mongo:5.0.4-focal
```

# View documents in mongodb

Use mongosh 
```
-- Connect to mongosh
# mongosh

-- List all databases 
> show dbs

-- Select a database
> use reactive

-- List all collections
> show collections

-- Show all documents
> db.getCollection("employee").find()
```