# CollageCreator
## About
CollageCreator is a Java program for creating a collage of images from a set of twelve landscape and six portrait images. The program randomises the order of photos so different collages can be obtained from the same photos by re-running the program.

## Requirements
CollageCreator requires a Java Runtime Environment. Images should have an aspect ratio of 4:3 in order to be displayed properly.

## Usage
CollageCreator takes as its input two directories, one containing twelve landscape images and the other containing six portrait images.

### Example
To create a collage from images in the directories 'Landscape' and 'Portrait', the command would be:

    java -jar CollageCreator.jar Landscape Portrait
  
Note that the name of the folder containing landscape images should be the first argument.

## Output
CollageCreator generates a JPEG file containing a collage comprised of three columns of landscape images interspersed with two columns of portrait images. An example is shown in the file 'collage.jpg'.
