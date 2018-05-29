#!/usr/bin/python3

import boto3
import json
import subprocess
from PIL import Image

def license_plate_recognition():
    s3 = boto3.resource('s3')
    bucket=''
    fileName='Nothing'
    client=boto3.client('','')
                
    s3.meta.client.upload_file(fileName, bucket, fileName)
    response = client.detect_faces(Image={'S3Object':{'Bucket':bucket,'Name':fileName}},Attributes=['ALL'])
    source_img = s3.Object(bucket, fileName).get()
    
if __name__ == "__main__":
    license_plate_recognition()
