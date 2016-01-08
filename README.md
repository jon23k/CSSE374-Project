
The evolution of the design of the tool:
	-Milestone 1: describing how you originally designed the tool.
	-Milestone 2: describing how the design of your tool evolved as a result of adding support for uses and association arrows.
  Stating who did what.
  Instructions on how to use your code.


This readme was created by Jonathan Kurian and Andrew Stull

	-Milestone 1: We used the factory pattern method to program our ClassdecVisitor, ClassMethodVisitor and ClassFieldVisitor classes to the abstract class ClassVisitor. From there we were able to alter its visit, visitField and visitMethod classes respectively, such that we were able to pass the access from the java Class were reading from our OutputStream. We then dumped this information into ClassDataContainer, which had methods that then converted the info into a GraphViz ready format. 


	-Milestone 2: Since our task was to add support for uses and association arrows, we were able to alter a very few amount of code to achieve association arrow support. It was easy to add association arrows because our visitMethod() used a return type which was able to access the “desc” string. With access to this “desc” string we were able to use the visitMethod to enable communication between our ClassMethodVisitor and our ClassDataContainer to print it.


WHO DID WHAT…
We solely paired programmed. Both members were there for the process and worked off of one laptop. The below contents will be described for each member’s time driving
Jonathan Kurian - OutputStream creation for Stankfile.txt, handling the DesignParser. Worked on ClassDataContainer. Made Tests

Andrew Stull - Creating the ClassdecVisitor, ClassMethodVisitor, and ClassFieldVisitor. Worked on ClassDataContainer. Made Tests. Solved Interface Issue


INSTRUCTIONS ON HOW TO USE OUR CODE
1) Find the DesignParser class
2) Open the DesignParser’s run configurations
3) Add your the class you want GraphViz to convert into as one of the arguments in the run configurations
4) Run DesignParser
5) Go to the “lib” folder in Project_One
6) Open Stankfile.txt inside of the “lib” folder (If there is no Stankfile then something terribly wrong has happened)
7) Copy & Paste the contents of the Stankfile.txt into GraphViz
8) Run the pasted content on GraphViz
9) Stare at UML Diagram (Hopefully one is created!!!)