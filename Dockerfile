FROM postgres
ENV POSTGRES_PASSWORD docker
ENV POSTGRES_DB persons
COPY persons.sql /docker-entrypoint-initdb.d/
