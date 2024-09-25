/*
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache.
If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.
*/

import java.util.HashMap;

public class LRUCache_146 {
    // Define a nested class Node to represent each entry in the doubly linked list.
    class Node {
        int key;  // Stores the key of the cache entry.
        int val;  // Stores the value of the cache entry.
        Node prev;  // Points to the previous node in the linked list.
        Node next;  // Points to the next node in the linked list.

        // Constructor to create a new node with a given key and value.
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    // Create a dummy head and tail for the doubly linked list to simplify operations.
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int cap;  // Stores the capacity of the LRU Cache.
    HashMap<Integer, Node> m = new HashMap<>();  // Maps keys to nodes in the linked list.

    // Constructor to initialize the LRU Cache with a given capacity.
    public LRUCache_146(int capacity) {
        cap = capacity;  // Set the capacity.
        head.next = tail;  // Initially, head's next points to tail (empty list).
        tail.prev = head;  // Initially, tail's prev points to head (empty list).
    }

    // Helper method to add a node right after the head.
    private void addNode(Node newNode) {
        Node temp = head.next;  // Store the current first node.

        newNode.next = temp;  // Point newNode's next to the current first node.
        newNode.prev = head;  // Point newNode's prev to head.

        head.next = newNode;  // Now head's next points to the new node.
        temp.prev = newNode;  // The former first node's prev now points to the new node.
    }

    // Helper method to delete a node from the linked list.
    private void deleteNode(Node delNode) {
        Node prevv = delNode.prev;  // Get the previous node.
        Node nextt = delNode.next;  // Get the next node.

        prevv.next = nextt;  // Link previous node to the next node.
        nextt.prev = prevv;  // Link next node to the previous node.
    }

    // Method to get the value of a key from the cache.
    public int get(int key) {
        if (m.containsKey(key)) {  // Check if the key is in the cache.
            Node resNode = m.get(key);  // Get the node associated with the key.
            int ans = resNode.val;  // Extract the value to return.

            m.remove(key);  // Remove the node from the map.
            deleteNode(resNode);  // Remove the node from the linked list.
            addNode(resNode);  // Add the node back to the front of the linked list (mark as recently used).

            m.put(key, head.next);  // Put the node back into the map with its new position.
            return ans;  // Return the value.
        }
        return -1;  // If the key is not found, return -1.
    }

    // Method to put a key-value pair into the cache.
    public void put(int key, int value) {
        if (m.containsKey(key)) {  // If the key already exists,
            Node curr = m.get(key);  // Get the current node.
            m.remove(key);  // Remove the node from the map.
            deleteNode(curr);  // Remove the node from the linked list.
        }

        if (m.size() == cap) {  // If the cache is full,
            m.remove(tail.prev.key);  // Remove the least recently used (LRU) node's key from the map.
            deleteNode(tail.prev);  // Remove the LRU node from the linked list.
        }

        addNode(new Node(key, value));  // Add the new node at the front (mark as most recently used).
        m.put(key, head.next);  // Add the new node to the map.
    }
}
