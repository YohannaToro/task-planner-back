package edu.escuelaing.demo.controller;

import edu.escuelaing.demo.model.Board;
import edu.escuelaing.demo.model.Task;
import edu.escuelaing.demo.model.TaskList;
import edu.escuelaing.demo.repository.mongo.TaskRepository;
import edu.escuelaing.demo.service.TaskPlannerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.mongodb.client.gridfs.model.GridFSFile;

@RestController
@RequestMapping(value = "/boards")
@CrossOrigin
public class TaskController {
    @Autowired
    GridFsTemplate gridFsTemplate;
    @Autowired
    TaskPlannerService taskServices;
    @Autowired
    TaskRepository taskRepository;

    @RequestMapping("/files/{filename}")
    public ResponseEntity<InputStreamResource> getFileByName(@PathVariable String filename) throws IOException {
        GridFSFile file = gridFsTemplate.findOne(new Query().addCriteria(Criteria.where("filename").is(filename)));
        if (file == null) {
            System.out.println("papau esa mamada nada de chunks");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            GridFsResource resource = gridFsTemplate.getResource(file.getFilename());
            return ResponseEntity.ok().contentType(MediaType.valueOf(resource.getContentType()))
                    .body(new InputStreamResource(resource.getInputStream()));
        }

    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Board>> getAllBoards() {

        List<Board> data = taskServices.getAllBoards();
        // System.out.println(data.size());
        return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBoardById(@PathVariable("id") String id) {

        try {
            taskRepository.findAll();
            Board data = taskServices.getBoardbyId(id);
            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/tasks")
    public ResponseEntity<?> getAllTasks() {

        List<Task> data = taskRepository.findAll();
        // System.out.println(data.size());
        return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}/{idTask}")
    public ResponseEntity<?> getTaskListbyId(@PathVariable("id") String id, @PathVariable("idTask") String idTask) {

        try {
            TaskList data = taskServices.getTaskListById(id, idTask);
            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @CrossOrigin("*")
    @PostMapping("/tasks/addTask")
    public ResponseEntity<?> createTask(@RequestBody Task task) {
        try {
            System.out.println("amiga date cuenta");
            System.out.println(task.getName());

            System.out.println(task.getFileUrl());

            taskRepository.save(task);
            return new ResponseEntity<>("done", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        String name = file.getOriginalFilename();
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(new File(name + "-uploaded")));
                stream.write(bytes);
                stream.close();
                gridFsTemplate.store(file.getInputStream(), file.getOriginalFilename(), file.getContentType());
                return "You successfully uploaded " + name + " into " + name + "-uploaded !";
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
    }

   /* @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }*/

}
