# HouseKeeping
Read Me File has been added in github
link:https://github.com/ameenamed/HouseKeeping

Main Activity:
It has all the buttons to all the API's which were presented in the question. Google Firebase has been used as a database.Link to Google Firebase Database:https://housekeeping-aa448.firebaseio.com/
Buttons:
1. Add Asset - It redirects to the Activity where assets can be added to the database. Eg. Chair,Table etc. Asset id and Description to be entered by the user.Asset id should be unique.
2. Add Task - This button redirects to the activity where user has to enter the task id and Description of the task. The task id should be unique.
3. Add Worker - This button redirects to the activity where user has to enter the worker id and Skills which can be done by workers separated by ','.
4. List of All Existing Assets - This button lists out all the assets present in the database.It fetches based on the word "Asset" which is present as a key in Firebase json tree.
5. Allocate Task - This button allocates the task according to asset id ,worker id and task id and ask user to input the current time as well as time required by the worker to finish the particular task
6. Get task for worker - Based on worker id the task id alloted to him are fetched from the database.


Main2Activity Activity:
This activity is for adding asset. User have to input asset id and description and two buttons are provided 1. Cancel - to get back to main activity 2. To add the data to database.


Main3Activity Activity:
This activity is for adding tasks. User have to input task id and description and two buttons are provided 1. Cancel - to get back to main activity 2. To add the data to database.

Main4Activity Activity:
This activity is for adding workers. User have to input worker id and description and two buttons are provided 1. Cancel - to get back to main activity 2. To add the data to database.

Main5Activity Activity:
This activity is for reading the Assets from the database and display it in the form of ListView.The Button provided in this activity is to navigate back to the MainActivity.

Main6Activity Activity:
This activity is to allocate task based on AssetId,TaskId and WorkerId and time is inputted (both Current and Allotted to worker) and stored in the database.

Main7Activity Activity:
This activity is to retrieve the task has been allotted to the workers based on their IDs.

Firebase Console
Children of Main Activity in Firebase database:
1. Asset
2. Task
3. Worker
4. Allocate
