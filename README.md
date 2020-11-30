# PredatorPreyProgram
Simple Agent-base Predator Prey Model Program. In the agent model, wolves and sheep wander randomly around the landscape, while the wolves look for sheep to prey on. Each step costs the wolves energy, and they must eat sheep in order to replenish their energy - when they run out of energy they die. To allow the population to continue, each wolf or sheep has a fixed probability of reproducing at each time step. Based on NetLogo Agent-Based Model.

Implemented by Spike Lee.

Attributes:
1. INITIAL NUMBER SHEEP: The initial size of sheep population  
2. INITIAL NUMBER WOLVES: The initial size of wolf population  
3. SHEEP-REPRODUCE: The probability of a sheep reproducing at each time step
4. SHEEP MAX INITIAL ENERGY: At start, sheep are given an energy value
5. WOLF GAIN FROM FOOD: The amount of energy wolves get for every sheep eaten  
6. WOLF REPRODUCE: The probability of a wolf reproducing at each time step
7. TICKS: Number of timesteps the model will run.

Things to do:
1. Code Cleanup
2. Add more comments


Possible extensions to try:
1. allow for a food chain system (ie. something eats wolves who eat sheep)
2. Optimize structure and flow of systems within program (eating,moving,etc)
