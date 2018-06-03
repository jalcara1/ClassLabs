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

    cap = cv2.VideoCapture(0)

    while(True):
        # Capture frame-by-frame
        ret, frame = cap.read()

        # Our operations on the frame come here
        gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)

        # Display the resulting frame
        cv2.imshow('frame', gray)
        if cv2.waitKey(1) & 0xFF == ord('q'):
            break

    # When everything done, release the capture
    cap.release()
    cv2.destroyAllWindows()
    
def main():
    license_plate_recognition()

if __name__ == '__main__':
    main()


