# Sling Clientlibs

## Modules
- `core` - components related code and scripts
- `ui.frontend` - front-end build
- `tests` - responsible for the automatic validation of the components
  - `content` - the minimal set of components and pages used during testing
  - `end-to-end` - end-to-end tests validating both components on authoring and publication

## Development

### Build

```bash
./mvnw clean install
```

### Running end-to-end tests

```bash
./mvnw clean install -P e2e
```

### Running dev instance
After building the project, start MongoDB:

```bash
docker run -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME=mongoadmin -e MONGO_INITDB_ROOT_PASSWORD=mongoadmin mongo:4.4.6
```


and run test feature using Sling Launcher from `tests/end-to-end` directory:

```bash
java -jar target/dependency/org.apache.sling.feature.launcher.jar -f target/slingfeature-tmp/feature-sling-clientlibs-tests.json
```

Instance should start at http://localhost:8080/ in a couple of seconds (default credentials: `wsadmin/wsadmin`).

## Contributing
Please read our [Contributing Guide](./CONTRIBUTING.md) before submitting a Pull Request to the project.

## License
Clientlibs is `open-source` project with `Apache License 2.0` license.
