# ETAPA 1: BUILD
FROM node:20 AS build
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build

# ETAPA 2: RUNTIME (Usando Nginx)
FROM nginx:alpine
EXPOSE 80
RUN rm /etc/nginx/conf.d/default.conf
COPY --from=build /app/dist /usr/share/nginx/html