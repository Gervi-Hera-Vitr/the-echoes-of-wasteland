#!/usr/bin/env python
import subprocess

actions = {
    "actions/checkout": {
        "symbolic_tag": "v4",
        "latest_tag": "main",
        "explicit_tag": "v4.2.2"
    },
    "gradle/actions": {
        "symbolic_tag": "v4",
        "latest_tag": "main",
        "explicit_tag": "v4.1.0"
    },
    "github/codeql-action": {
        "symbolic_tag": "v3",
        "latest_tag": "main",
        "explicit_tag": "v3.27.0"
    }
}

# Function to get the commit hash for a specific tag
def get_commit_hash(repo, tag):
    """
    Get the commit hash for a specific tag from a GitHub repository.

    Parameters
    ----------
    repo : str
        The name of the GitHub repository to query.
    tag : str
        The tag to query for the commit hash.

    Returns
    -------
    str
        The commit hash for the specified tag, or "N/A" if it's not found.
    """
    try:
        result = subprocess.run(
            ["git", "ls-remote", f"https://github.com/{repo}.git", tag],
            capture_output=True,
            text=True,
            check=True
        )
        return result.stdout.split()[0] if result.stdout else "N/A"
    except subprocess.CalledProcessError:
        return "N/A"

# Loop through each action and print its details with hashes
for action, tags in actions.items():
    symbolic = tags["symbolic_tag"]
    latest = tags["latest_tag"]
    explicit = tags["explicit_tag"]

    # Fetch commit hashes
    symbolic_hash = get_commit_hash(action, symbolic)
    latest_hash = get_commit_hash(action, latest)
    explicit_hash = get_commit_hash(action, explicit)

    # Print in two-row format
    print(f"action: {action:<34} => symbolic: {symbolic:>3}|-> {symbolic_hash:<40};    explicit: {explicit:>7}|-> {explicit_hash:<40};    latest: {latest:>7}|-> {latest_hash:<40}")
