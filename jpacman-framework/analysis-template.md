# Specification-based Testing

## 1. Goal, inputs and outputs
- Goal: Find the next clyde move
- Input domain: user map, clyde position
- Output domain: next clyde position, a direction or nothing
## 2. Explore the program (if needed)
- Increase the understanding of the what the program does
- Consider happy paths
  - Corner cases are left for later
## 3. Identify input and output partitions

### Input partitions 

#### Individual inputs
- Distance partition du pacman par rapport a pac-man p
  - Distance  < 8, the clyde run away
  - Distance > 8, the clyde get nearer
  - Distance == 8

- Pac-man on the board partition
- Pac-man not on the board partition
- pac-man does not have a square partition

- obstacle partition
  - Path of clyde is free
  - path of clyde is blocked
  - Clyde is on pac-man
- Not valide
  - multiple clyde on the board
  - multiple pac-man on the board
#### Combinations of input values
Combination of distance and obstacle partition
### Output partitions

- Direction

## 4. Identify boundaries

## 5. Select test cases
Putting input and output together