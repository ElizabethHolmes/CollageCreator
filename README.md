# CollageCreator
## About
CollageCreator is a Java program for creating a collage of images from a set of twelve landscape and six portrait images. Images should have an aspect ratio of 4:3 in order to be displayed properly. The program randomises the order of photos so different collages can be obtained from the same photos by re-running the program.

** PLEASE NOTE: CollageCreator is one of my first Java programs written as a beginner Java programmer and so I apologise if the code is inelegant, unconventional or otherwise sub-optimal; it works for the intended purpose and I provide it in case it might be useful to others, but with no guarantees. **

## Requirements
GeneDiagram requires a Java Runtime Environment.

## Usage
CollageCreator takes as its input two directories, one containing twelve landscape images and the other containing six portrait images.

### Example
To create a collage from images in the directories 'Landscape' and 'Portrait', the command would be:

  java -jar CollageCreator.jar Landscape Portrait
  
Note that the name of the folder containing landscape images should be the first argument.

## Output
CollageCreator generates a JPEG file containing a collage comprised of three columns of landscape images interspersed with two columns of portrait images. An example is shown in the file 'collage.jpg'.
