#Create Docker File
#Open Docker Desktop
# Build image
docker build -t document-hub:1.0 .

# Run container
docker run -d -p 8080:8080 --name documenthub document-hub:1.0