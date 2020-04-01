# Xiang Xi's CPSC 210 Personal Project

## Online Sketching Tool

**What will the application do?**  

For this application, I will be creating an online sketch pad with feature that are similar to microsoft paint. This
application should allow users to draw and write whatever they desire on a blank canvas. There will be a 
selection of tools in a toolbar for users to choose from such as a pencil, an eraser, different colors and potentially 
even shapes and clipart. 

**Who will use it?**

Overall, this program will act as place to draw and scribble whatever the user desires. This program will be available
to all audiences and there is no constraint to who can use it. I believe that anyone who needs a place to write 
something down or just draw whatever they want will have the ability to use this application.

**Why is this project of interest to you?**

I decided to create this project myself because I see myself using it a lot. Often times I just need a quick place to 
jot down a note or create a diagram for myself during my studies, but I do not want to take out some paper and write
it by hand. I believe that having an application like this at one's disposal allows for an easier time when working and 
studying. 

## User Stories

- As a user, I want to be able to add a pixel to the canvas
- As a user, I want to be able to change the color of my pencil
- As a user, I want to be able to change the size of my pencil
- As a user, I want to be able to change the color of my pixel
- As a user, I want to be able to save the canvas that I have added to the Canvas
- As a user, I want to be able to load the pixel that I have added to the Canvas

## How to Run the Program

**Running the program:**
Run the PaintApp class. A window should pop up called PaintApp

**Using the pencil tool:**
To draw on the canvas using the pencil, click on the pencil button first and then draw on the canvas by clicking then 
dragging the mouse.

**Using the Eraser tool:**
In order to use the eraser function, follow the save instructions for the pencil button but instead, press the eraser
 button

**Using the save function:** 
When you want to save the drawing, click the save button and it will be saved to the file

**Using the load function:**
This load button will always reload the previous save. Just click the load button and whatever was previously saved 
will appear on the screen. Any non-saved changed will be gone.

##  Phase 4: Task 2
In my project, I have chosen to implement a type hierarchy for my tools. In this type hierarchy, I have an abstract
class called tools that contains methods general such as whether the tool is active or not. Additionally, I have
abstract methods, getSize() and setSize() that are implemented in my pencil too and eraser tool classes. These
two methods are specific for each tool and can be different from each other. Furthermore, I have a String field
called description that indicates the name of each tool. This field is public and is declared in the sub-tool 
classes of the abstract class. 

##Phase 4: Task 3
Places in which there are is too much coupling or poor cohesion are:
1. Poor Cohesion in ToolPanel SaveCanvas(), LoadCanvas() methods.
- These two methods supply the action component for the buttons in my ToolPanel class. However I realized they have
more to do with data that ui so I decided to move them into my Canvas class. The Canvas class deals with my data for
the application which is a better fit for these methods. Thus, this improves on cohesion as the the methods are
properly separated into their specified classes.

2. Poor Cohesion in CanvasPanel export() method:
- Similar to the first issue, this method also deals with data rather than ui. In this case, the export method turns
the canvas into a JSONObject such that it can be stored. Thus, I moved this into the Canvas class as well to improve
cohesion. I also renamed this method to exportApp() as I have a previous method that exported the canvas for my
console application.










