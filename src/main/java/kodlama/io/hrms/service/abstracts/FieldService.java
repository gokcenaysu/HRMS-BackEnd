package kodlama.io.hrms.service.abstracts;

import kodlama.io.hrms.core.utilities.results.Result;

public interface FieldService<T> {

    Result verifyRegister (T data);
 //   Result updateAccount (T data);
    Result deleteAccount (T data);
    Result verifyLogin (T data);
}
