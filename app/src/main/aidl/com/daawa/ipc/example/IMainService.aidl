package com.daawa.ipc.example;
import com.daawa.ipc.example.MarshallObject;

interface IMainService {
    MarshallObject[] listFiles(String path);

    void exit();
}
