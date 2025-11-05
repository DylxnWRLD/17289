FROM alpine
EXPOSE 80
RUN apk add nginx
COPY ./ordinario-ftw /var/lib/nginx/html/
COPY ./dylan.conf /etc/nginx/http.d/default.conf
#permisos
CMD ["nginx", "-g", "daemon off;"]
#-g 'daemon off;'