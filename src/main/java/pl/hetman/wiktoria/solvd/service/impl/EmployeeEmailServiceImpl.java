package pl.hetman.wiktoria.solvd.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.Email;
import pl.hetman.wiktoria.solvd.model.Employee;
import pl.hetman.wiktoria.solvd.model.EmployeeContactEmail;
import pl.hetman.wiktoria.solvd.persistence.impl.EmployeeEmailMyBatisImpl;
import pl.hetman.wiktoria.solvd.service.EmployeeEmailService;

import java.util.Optional;

public class EmployeeEmailServiceImpl implements EmployeeEmailService {

    private static final Logger LOGGER = LogManager.getLogger(EmployeeEmailServiceImpl.class);

    private final EmployeeEmailMyBatisImpl employeeEmailRepo;

    public EmployeeEmailServiceImpl(EmployeeEmailMyBatisImpl employeeEmailRepo) {
        this.employeeEmailRepo = employeeEmailRepo;
    }


    @Override
    public Optional<EmployeeContactEmail> addEmail(Employee employee, Email email) {
        return Optional.empty();
    }

    @Override
    public Optional<EmployeeContactEmail> findById(Long id) throws ToyShopException{
        if(id==null){
            throw new ToyShopException("Can't find EmployeeContactEmail, id is null ");
        } else {
            Optional<EmployeeContactEmail> foundedEmployeeContactEmail = employeeEmailRepo.findById(id);
            return foundedEmployeeContactEmail;
        }
    }

    @Override
    public void deleteById(Long id) {

    }
}
