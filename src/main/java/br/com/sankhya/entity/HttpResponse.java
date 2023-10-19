package br.com.sankhya.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;

@JsonInclude( Include.NON_NULL )
@JsonIgnoreProperties( ignoreUnknown = true )
public class HttpResponse implements Serializable {

        private static final long serialVersionUID = -8668176334547945413L;

        private Integer status;

        private Object object;

        private String message;


        public HttpResponse(Integer status ) {

                this.status = status;
        }


        public HttpResponse(Integer status, String message ) {

                this.status = status;
                this.message = message;
        }


        public HttpResponse(Integer status, Object object ) {

                this.status = status;
                this.object = object;
        }


        public Integer getStatus() {

                return status;
        }


        public Object getObject() {

                return object;
        }


        public String getMessageKey() {

                return message;
        }


        public void setMessageKey( String message ) {

                this.message = message;
        }


        public void setStatus( Integer status ) {

                this.status = status;
        }


        public void setObject( Object object ) {

                this.object = object;
        }


        public String getMessage() {

                return message;
        }


        public void setMessage( String message ) {

                this.message = message;
        }
}
