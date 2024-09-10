public class GasStation_134 {

    /*There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
    You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station.
    You begin the journey with an empty tank at one of the gas stations.
    Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction,
    otherwise return -1. If there exists a solution, it is guaranteed to be unique.

    Example 1:
    Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
    Output: 3
    Explanation:
    Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
    Travel to station 4. Your tank = 4 - 1 + 5 = 8
    Travel to station 0. Your tank = 8 - 2 + 1 = 7
    Travel to station 1. Your tank = 7 - 3 + 2 = 6
    Travel to station 2. Your tank = 6 - 4 + 3 = 5
    Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
    Therefore, return 3 as the starting index.*/

/*
**Step-by-Step Execution**:
    1. First Loop (Calculate Total Gas and Total Cost):
    - `sGas = 1 + 2 + 3 + 4 + 5 = 15`
    - `sCost = 3 + 4 + 5 + 1 + 2 = 15`
    - Since `sGas` equals `sCost`, it is possible to complete the circuit.

    2. Second Loop (Find the Starting Station):
    - Start from index 0:
    - `total = total + (gas[0] - cost[0]) = 0 + (1 - 3) = -2` (negative total, reset `total = 0`, move to next station)
    - Set `res = 1` (next station).
    - Start from index 1:
    - `total = total + (gas[1] - cost[1]) = 0 + (2 - 4) = -2` (negative total, reset `total = 0`, move to next station)
    - Set `res = 2`.
    - Start from index 2:
    - `total = total + (gas[2] - cost[2]) = 0 + (3 - 5) = -2` (negative total, reset `total = 0`, move to next station)
    - Set `res = 3`.
    - Start from index 3:
    - `total = total + (gas[3] - cost[3]) = 0 + (4 - 1) = 3` (positive total, continue).
    - Start from index 4:
    - `total = total + (gas[4] - cost[4]) = 3 + (5 - 2) = 6` (positive total, continue).
    - Circuit can be completed starting from index 3.

      **Output**: The function returns `3`, meaning starting from station 3 will allow completing the circuit.

### Key Intuition:
    - If the total gas is greater than or equal to the total cost, a valid solution exists.
     - By resetting when `total` becomes negative, you eliminate the possibility of starting the journey from any of the stations before that point.
This is because if you can't travel from station `i`, starting from any station before `i` would also not work.*/


    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sGas = 0, sCost = 0, res = 0, total = 0;
        for (int i = 0; i < gas.length; i++) {
            sGas += gas[i]; // Add gas available at station i to total gas.
            sCost += cost[i]; // Add the cost to travel from station i to the next to total cost.
        }
        if (sGas < sCost) return -1; // If total gas is less than total cost, return -1 as it's impossible to complete the circuit.

        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i]; // Track the remaining gas after visiting station i (net gas = gas[i] - cost[i]).
            if (total < 0) { // If the remaining gas goes negative, the current starting station isn't valid.
                total = 0; // Reset the remaining gas since the journey failed from this point.
                res = i + 1; // Set the next station (i+1) as the new candidate starting point.
            }
        }
        return res; // Return the starting station index where the journey can complete the circuit.
    }

}

