package com.taskmanager.taskmanager.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.taskmanager.taskmanager.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    // CREATE
    public String createTask(Task task) throws Exception {

        Firestore db = FirestoreClient.getFirestore();

        ApiFuture<DocumentReference> future =
                db.collection("tasks").add(task);

        return "Task Created Successfully";
    }

    // READ
    public List<Task> getAllTasks() throws Exception {

        Firestore db = FirestoreClient.getFirestore();

        Iterable<DocumentReference> documents =
                db.collection("tasks").listDocuments();

        List<Task> taskList = new ArrayList<>();

        for(DocumentReference doc : documents){

            DocumentSnapshot snapshot = doc.get().get();

            Task task = snapshot.toObject(Task.class);

            task.setId(doc.getId());

            taskList.add(task);
        }

        return taskList;
    }

    // UPDATE
    public String updateTask(String id, Task task) {

        Firestore db = FirestoreClient.getFirestore();

        db.collection("tasks").document(id).set(task);

        return "Task Updated Successfully";
    }

    // DELETE
    public String deleteTask(String id) {

        Firestore db = FirestoreClient.getFirestore();

        db.collection("tasks").document(id).delete();

        return "Task Deleted Successfully";
    }
}