/*There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule_207 {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<Integer>[] adj = new List[n];  // Create an adjacency list to represent the graph.
        int[] indegree = new int[n];  // Create an array to track the indegree (number of prerequisites) of each course.
        List<Integer> ans = new ArrayList<>();  // This list will store the order in which courses can be completed.

        // Populate the graph and indegree array based on the prerequisites.
        for (int[] pair : prerequisites) {
            int course = pair[0];  // Get the course.
            int prerequisite = pair[1];  // Get the prerequisite for the course.

            if (adj[prerequisite] == null) {
                adj[prerequisite] = new ArrayList<>();  // Initialize the adjacency list if null.
            }
            adj[prerequisite].add(course);  // Add the course to the adjacency list of the prerequisite.
            indegree[course]++;  // Increase the indegree of the course because it has one more prerequisite.
        }

        // Initialize a queue and enqueue all courses with no prerequisites (indegree = 0).
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {  // If the course has no prerequisites, enqueue it.
                queue.offer(i);
            }
        }

        // Process the queue.
        while (!queue.isEmpty()) {
            int current = queue.poll();  // Dequeue a course.
            ans.add(current);  // Add the course to the answer list.

            // If the current course has any dependent courses (adjacent nodes).
            if (adj[current] != null) {
                for (int next : adj[current]) {  // For each dependent course.
                    indegree[next]--;  // Reduce its indegree by 1, because one of its prerequisites has been completed.
                    if (indegree[next] == 0) {  // If the course now has no prerequisites, enqueue it.
                        queue.offer(next);
                    }
                }
            }
        }

        // If the number of courses in the answer list is equal to the total number of courses, return true.
        // This means all courses can be completed.
        return ans.size() == n;
    }
}

/*
Explanation of the Algorithm:
Graph Representation (Adjacency List):
The courses and their prerequisites are represented as a directed graph, where each node is a course, and a directed edge
from course A to course B means A is a prerequisite for B. The adjacency list (adj) stores this information,
and the indegree array tracks how many prerequisites each course has.

Topological Sort Using BFS:
The problem is essentially about detecting a cycle in a directed graph. If there’s a way to complete all courses,
it means the graph has no cycles and can be "topologically sorted." The algorithm uses BFS (Breadth-First Search) to perform a topological sort:

It starts with courses that have no prerequisites (indegree == 0).
As courses are completed, it reduces the prerequisites (indegree) of other courses dependent on them.
If a course’s indegree becomes 0, it’s added to the queue to be completed.
Cycle Detection:
If a cycle exists, some courses will never have an indegree of 0, meaning the number of completed courses
will be less than n by the end. In that case, the function returns false.

Walkthrough Example:
Let's go through an example:

Input:
n = 4 (4 courses)
prerequisites = [[1, 0], [2, 1], [3, 2]]
This means:

Course 1 requires course 0 as a prerequisite.
        Course 2 requires course 1 as a prerequisite.
        Course 3 requires course 2 as a prerequisite.
        Step 1: Construct the Graph and Indegree Array
Adjacency list (adj):

less
[0]: [1]  // Course 0 is a prerequisite for course 1.
[1]: [2]  // Course 1 is a prerequisite for course 2.
[2]: [3]  // Course 2 is a prerequisite for course 3.
[3]: null
Indegree array (indegree):

csharp
[0, 1, 1, 1]  // Course 0 has 0 prerequisites, course 1 has 1, course 2 has 1, and course 3 has 1.
Step 2: Initialize the Queue
We enqueue courses with indegree == 0. In this case, only course 0 has no prerequisites:

Queue: [0]
Step 3: Process the Queue (Topological Sort)
Dequeue 0:

Add 0 to the result (ans = [0]).
Course 1 depends on 0, so we reduce the indegree of course 1 by 1 (indegree[1] = 0).
Since indegree[1] == 0, we enqueue course 1:

Queue: [1]
Indegree: [0, 0, 1, 1]
Dequeue 1:

Add 1 to the result (ans = [0, 1]).
Course 2 depends on 1, so we reduce the indegree of course 2 by 1 (indegree[2] = 0).
Since indegree[2] == 0, we enqueue course 2:

Queue: [2]
Indegree: [0, 0, 0, 1]
Dequeue 2:

Add 2 to the result (ans = [0, 1, 2]).
Course 3 depends on 2, so we reduce the indegree of course 3 by 1 (indegree[3] = 0).
Since indegree[3] == 0, we enqueue course 3:

Queue: [3]
Indegree: [0, 0, 0, 0]
Dequeue 3:

Add 3 to the result (ans = [0, 1, 2, 3]).
Step 4: Check if All Courses are Completed
At the end, the ans list contains all courses ([0, 1, 2, 3]), which is equal to n = 4. Thus,
all courses can be completed, and the function returns true.
*/
