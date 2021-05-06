package bdn.restprojeckt.jagent.controller;

import bdn.restprojeckt.jagent.model.Tasks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TaskController {
    private static final Logger log = LoggerFactory.getLogger(TaskController.class);
   // private HashMap<Integer, Tasks> tasksHashMap = new HashMap();
    private Tasks tasks = new Tasks();
    private final AtomicLong id = new AtomicLong();


    @GetMapping("/task")
    public Tasks getTask(@RequestParam (value = "id", defaultValue = "1") int getId){
        log.info("Get : "+ tasks.getTask());
        return tasks;
    }

    @PostMapping("/task")
    public Tasks  addTask(@RequestParam (value = "id") int postId,
                                                @RequestParam (value = "tasks" )String task){
        tasks  = new Tasks(postId,task,"run", new Date());
        log.info("Post tasksHashMap.size: "+ tasks.getTask());
        executeTask(tasks);
        return tasks;
    }

    private void executeTask(Tasks tasksEx){
        String task;
        Date date;
        if(tasksEx != null) {
                task = tasksEx.getTask();
                date = tasksEx.getDate();
                log.info("Выполняю задание: " + task + " от " + date);
                log.info("command to execute: "+ task);
            try {
                Process process =   Runtime.getRuntime().exec(task);

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(process.getInputStream()));
                String line = null;
                while ((line = in.readLine()) != null) {
                    log.info("exec response : "+ line);
                }
            } catch ( IllegalThreadStateException e){
                log.info("ERROR: " , e);
            }
            catch (NullPointerException e){
                log.info("Passed zero value in doProcess(String command) ");
                log.info("ERROR: " , e);
            }
            catch (IOException e) {
                log.info("ERROR: " , e);
            }
        } else
        log.info("Tasks : " + "null");
    }


}
