package com.example.caso.services.interfase;

import java.util.List;
import java.util.Optional;

import com.example.caso.entity.Editoriales;

public interface EditorialesService {
    
    public abstract List <Editoriales> listAllEditoriales();

    public abstract Optional <Editoriales> findByIdEditoral (long id);

    public abstract Editoriales updateEditorial (Editoriales editoriales);

    public abstract void deleteEditorial (long id);

    Editoriales create(Editoriales editoriales);
}
