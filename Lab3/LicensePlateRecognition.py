#!/usr/bin/python3

import multiprocessing 
import boto3
import json
import cv2
import re

def amazon_aws(image):
    s3=boto3.resource('s3')
    bucket='telematicaequipo3'
    s3=boto3.resource('s3')
    photo=image
    client=boto3.client('rekognition')
    s3.meta.client.upload_file(photo, bucket, photo)
    response=client.detect_text(Image={'S3Object':{'Bucket':bucket,'Name':photo}})
    textDetections=response['TextDetections']
    print("Image Processed")
    for text in textDetections:
        print ('Detected text:' + text['DetectedText'])
        print ('Confidence: ' + "{:.2f}".format(text['Confidence']) + "%")

def license_plate_recognition():
    faceCascade = cv2.CascadeClassifier('haarcascade_cars.xml')
    video_capture = cv2.VideoCapture(0)
    cpt = 0

    while True:
        # Capture frame-by-frame
        ret, frame = video_capture.read()
        gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
        faces = faceCascade.detectMultiScale(
            gray,
            scaleFactor=1.1,
            minNeighbors=5,
            minSize=(30, 30),
            flags=cv2.CASCADE_SCALE_IMAGE
        )
        photo = str(faces)
        print("---->> " + photo + " ------ " + str(len(photo)))
        
        if len(photo) > 4:
            picture = "image%04i.jpg" %cpt
            cv2.imwrite(picture, frame)
            
            thread = multiprocessing.Process(target=amazon_aws, args=(picture,))
            thread.start()
            
            cpt += 1
            print("Image Written!")
        
        # Draw a rectangle around the faces
        for (x, y, w, h) in faces:
            cv2.rectangle(frame, (x, y), (x+w, y+h), (0, 255, 0), 2)
        # Display the resulting frame
        frame_copy = cv2.flip(frame, 1)
        cv2.imshow('Video', frame_copy)
        fps = video_capture.get(cv2.CAP_PROP_FPS)
        print("Frames per second using video.get(cv2.cv.CV_CAP_PROP_FPS): {0}".format(fps))
        if cv2.waitKey(1) & 0xFF == ord('q'):
            break
    # When everything is done, release the capture
    video_capture.release()
    cv2.destroyAllWindows()

def main():
    license_plate_recognition()

if __name__ == '__main__':
    main()
