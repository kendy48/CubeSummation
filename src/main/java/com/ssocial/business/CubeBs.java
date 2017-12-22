package com.ssocial.business;

import com.ssocial.exception.ControllerException;
import com.ssocial.model.request.SolveCubeRequest;
import org.springframework.stereotype.Component;

import static com.ssocial.exception.ErrorResponses.*;

/**
 * Created by kendy on 22/12/17.
 */
@Component
public class CubeBs {

    public static final Integer MIN_CASES = 1;
    public static final Integer MAX_CASES = 50;
    public static final Integer MIN_CUBE_SIZE = 1;
    public static final Integer MAX_CUBE_SIZE = 100;
    public static final Integer MIN_OPERATION_SIZE = 1;
    public static final Integer MAX_OPERATION_SIZE = 1000;
    public static final Long MIN_VALID_VALUE = -10000000000l;
    public static final Long MAX_VALID_VALUE = 10000000000l;

    public String solveCube(SolveCubeRequest request) throws ControllerException {
        StringBuffer response = new StringBuffer();
        //Validamos que el request
        if(!request.isValid()){
            throw new ControllerException(INVALID_SOLVE_CUBE_REQUEST);
        }
        String[] lines = request.getInput().split("\n");

        int cases = 0;

        //Verificamos el numero de casos
        try{
            cases = Integer.valueOf(lines[0]);
        } catch (Exception e){
            throw new ControllerException(INVALID_CASE_NUMBER);
        }

        if(cases < MIN_CASES || cases > MAX_CASES){
            throw new ControllerException(INVALID_CASE_NUMBER);
        }

        //hacemos un loop por el numero de casos
        int lineCounter = 1;
        for(int i=0; i<cases; i++){

            //Obtenermos los valores del caso y validamos el tamano del cubo y el numero de operaciones
            String[] mainValues = lines[lineCounter].split(" ");
            lineCounter++;
            if(mainValues.length != 2){
                throw new ControllerException(INVALID_MAIN_CASE_VALUES);
            }

            int n = 0;
            //Verificamos el tamano del cubo sea valido
            try{
                n = Integer.valueOf(mainValues[0]);
            } catch (Exception e){
                throw new ControllerException(INVALID_CUBE_NUMBER);
            }

            if(n < MIN_CUBE_SIZE || n > MAX_CUBE_SIZE){
                throw new ControllerException(INVALID_CUBE_NUMBER);
            }

            int m = 0;
            //Verificamos el numero de Operaciones sea valido
            try{
                m = Integer.valueOf(mainValues[1]);
            } catch (Exception e){
                throw new ControllerException(INVALID_OPERATION_NUMBER);
            }

            if(m < MIN_OPERATION_SIZE || m > MAX_OPERATION_SIZE){
                throw new ControllerException(INVALID_OPERATION_NUMBER);
            }

            //inicializamos el cubo
            Long[][][] cubo = initializeCube(n);

            //resolvemos las operaciones
            for(int j=lineCounter; j<lineCounter+m; j++){
                String s = solveOperation(cubo, lines[j]);
                if(null != s){
                    response.append(s+"\n");
                }
            }
            lineCounter += m;
        }

        return response.toString();
    }

    private Long[][][] initializeCube(int size){
        Long[][][] cube = new Long[size][size][size];
        for(int x=0; x<size; x++){
            for(int y=0; y<size; y++){
                for(int z=0; z<size; z++) {
                    cube[x][y][z] = 0l;
                }
            }
        }
        return cube;
    }

    private String solveOperation(Long[][][] cube, String operation) throws ControllerException {
        if(null == operation || operation.length() == 0){
            throw new ControllerException(INVALID_OPERATION_QUERY_PARAMS);
        }
        String[] params = operation.split(" ");

        switch (params[0].toUpperCase()){
            case "UPDATE":
                //verificamos que los parametros de la operacion sean validos
                if(params.length != 5){
                    throw new ControllerException(INVALID_OPERATION_QUERY_PARAMS);
                }

                update(cube, params);
                return null;

            case "QUERY":
                //verificamos que los parametros de la operacion sean validos
                if(params.length != 7){
                    throw new ControllerException(INVALID_OPERATION_QUERY_PARAMS);
                }

                return query(cube, params);
        }
        return null;
    }



    private void update(Long[][][] cube, String[] params) throws ControllerException {
        try{
            int x = Integer.valueOf(params[1])-1;
            int y = Integer.valueOf(params[2])-1;
            int z = Integer.valueOf(params[3])-1;
            long value = Long.valueOf(params[4]);
            if(value < MIN_VALID_VALUE || value > MAX_VALID_VALUE){
                throw new ControllerException(INVALID_VALUE_NUMBER);
            }

            cube[x][y][z] = value;
        } catch (Exception e){
            throw new ControllerException(INVALID_VALUE_NUMBER);
        }

    }

    private String query(Long[][][] cube, String[] params) throws ControllerException {
        int x1 = Integer.valueOf(params[1])-1;
        int y1 = Integer.valueOf(params[2])-1;
        int z1 = Integer.valueOf(params[3])-1;
        int x2 = Integer.valueOf(params[4])-1;
        int y2 = Integer.valueOf(params[5])-1;
        int z2 = Integer.valueOf(params[6])-1;

        Long result = 0l;
        for(int x = x1; x <= x2; x++){
            for(int y = y1; y <= y2; y++){
                for(int z = z1; z <= z2; z++){
                    result = result + cube[x][y][z];
                }
            }
        }
        return result.toString();
    }

}
