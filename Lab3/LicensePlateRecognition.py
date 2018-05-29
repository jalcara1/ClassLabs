#!/usr/bin/python3

import subprocess
import boto3
import json
import cv2
import sys

from PIL import Image

def license_plate_recognition():
    #s3 = boto3.resource('s3')
    bucket=''
    fileName='Nothing'
    #client=boto3.client('','')
    
    #s3.meta.client.upload_file(fileName, bucket, fileName)
    #response = client.detect_faces(Image={'S3Object':{'Bucket':bucket,'Name':fileName}},Attributes=['ALL'])
    #source_img = s3.Object(bucket, fileName).get()

    # Get user supplied values                                               
    imagePath = sys.argv[1]
    cascPath = "/home/nose/.local/lib/python3.6/site-packages/cv2/data/haarcascade_russian_plate_number.xml"

    # Create the haar cascade                                                
    faceCascade = cv2.CascadeClassifier(cascPath)
    
    # Read the image                                                         
    image = cv2.imread(imagePath)
    gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
    
    print(str(gray))
    
    # Detect faces in the image                                              
    faces = faceCascade.detectMultiScale(
        gray,
        scaleFactor=1.1,
        minNeighbors=5,
        minSize=(30, 30),
        flags=cv2.CASCADE_SCALE_IMAGE
    )
    
    print("Found {0} License Plate!".format(len(faces)))
    
    # Draw a rectangle around the faces                                      
    for (x, y, w, h) in faces:
        cv2.rectangle(image, (x, y), (x+w, y+h), (0, 255, 0), 2)
        
        cv2.imshow("License Plate found", image)
        cv2.waitKey(0)
        
if __name__ == "__main__":
    license_plate_recognition()
