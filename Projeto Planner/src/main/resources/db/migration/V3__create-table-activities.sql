CREATE TABLE activities (
    id UUID RANDOM_UUID() PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    is_confirmed BOOLEAN NOT NULL,
    occurs_at TIMESTAMP NOT NULL,
    trip_id UUID,
    FOREIGN KEY (trip_id) REFERENCES trips(id) ON DELETE CASCADE
);